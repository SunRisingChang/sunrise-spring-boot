package com.sunrise.core.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;

/**
 * 集合转树工具类
 * 
 * @author Sun Rising
 * @date 2019.06.26 10:07:53
 *
 */
public class TreeUtils {

	private static final String ROOT = "ROOT";

	private static final String KEY = "id";

	private static final String PARENTKEY = "parent";

	private static final String CHILDREN = "children";

	/**
	 * 集合转树结构
	 * 
	 * @author Sun Rising
	 * @date 2019.06.26 10:01:05
	 * @param collection 目标集合
	 * @param clazz      集合元素类型
	 * @return
	 *
	 */
	public static <T> Collection<T> toTree(@NotNull Collection<T> collection, @NotNull Class<T> clazz) {
		return toTree(collection, null, null, null, null, clazz);
	}

	/**
	 * 集合转树结构
	 * 
	 * @author Sun Rising
	 * @date 2019.06.26 10:01:29
	 * @param collection 目标集合
	 * @param id         被依赖字段名称
	 * @param parent     依赖字段名称
	 * @param children   子节点集合属性名称
	 * @param clazz      集合元素类型
	 * @return
	 *
	 */
	public static <T> Collection<T> toTree(@NotNull Collection<T> collection, String root, String id, String parent, String children, @NotNull Class<T> clazz) {
		try {
			if (collection == null || collection.isEmpty())
				return null;// 如果目标集合为空,直接返回一个空树
			if (StringUtils.isEmpty(id))
				id = KEY;// 如果被依赖字段名称为空则默认为id
			if (StringUtils.isEmpty(parent))
				parent = PARENTKEY;// 如果依赖字段为空则默认为parent
			if (StringUtils.isEmpty(children))
				children = CHILDREN;// 如果子节点集合属性名称为空则默认为children
			if (StringUtils.isEmpty(root))
				root = ROOT;// 如果子节点集合属性名称为空则默认为root
			Collection<T> roots = null;// 初始化根节点集合
			if (collection.getClass().isAssignableFrom(Set.class))
				roots = new HashSet<>();// 如果目标节点是一个set集合,则初始化根节点集合为hashset
			else
				roots = new ArrayList<>();// 否则初始化为Arraylist,
			// 这里集合初始化只分2中,要么是hashset,要么ArrayList,因为这两种最常用,其他不常用的摒弃
			Field idField = null;
			try {
				idField = clazz.getDeclaredField(id);// 获取依赖字段
			} catch (NoSuchFieldException e1) {
				idField = clazz.getSuperclass().getDeclaredField(id);
			}
			Field parentField = null;
			try {
				parentField = clazz.getDeclaredField(parent);// 获取被依赖字段
			} catch (NoSuchFieldException e1) {
				parentField = clazz.getSuperclass().getDeclaredField(parent);
			}
			Field childrenField = null;// 获取孩子字段
			try {
				childrenField = clazz.getDeclaredField(children);
			} catch (NoSuchFieldException e1) {
				childrenField = clazz.getSuperclass().getDeclaredField(children);
			}
			// 设置为可访问
			idField.setAccessible(true);
			parentField.setAccessible(true);
			childrenField.setAccessible(true);
			// 找出所有的根节点
			for (T c : collection) {
				Object o = parentField.get(c);
				if (o instanceof String) {
					if (root.equals(o)) {
						roots.add(c);
					}
				} else {
					if (o == null) {
						roots.add(c);
					}
				}
			}
			// 从目标集合移除所有根节点
			collection.removeAll(roots);
			for (T c : roots) {// 遍历根节点,依次添加子节点
				addChild(c, collection, idField, parentField, childrenField);
			}
			// 关闭可访问
			idField.setAccessible(false);
			parentField.setAccessible(false);
			childrenField.setAccessible(false);
			return roots;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 为目标节点添加孩子节点,此方法为私有,不能为公开,否则类修改信息无法恢复,后面有公开方法,其专门为目标节点添加子节点
	 * 
	 * @author Sun Rising
	 * @date 2019.06.26 10:04:56
	 * @param c             目标节点
	 * @param collection    目标集合
	 * @param idField
	 * @param parentField
	 * @param childrenField
	 * @throws IllegalAccessException
	 *
	 */
	@SuppressWarnings("unchecked")
	private static <T> void addChild(@NotNull T c, @NotNull Collection<T> collection, @NotNull Field idField, @NotNull Field parentField, @NotNull Field childrenField) throws IllegalAccessException {
		Object id = idField.get(c);// 获取目标节点的被依赖值
		Collection<T> children = (Collection<T>) childrenField.get(c);// 获取目标节点的孩子列表
		for (T cc : collection) {// 遍历目标集合
			Object o = parentField.get(cc);// 获取当前节点的依赖值
			if (id.equals(o)) {// 如果当前节点的被依赖值和目标节点的被依赖值相等,则说明,当前节点是目标节点的子节点
				if (children == null) {// 如果目标节点的孩子集合为null,初始化目标节点的孩子集合
					if (collection.getClass().isAssignableFrom(Set.class)) {// 如果目标集合是一个set集合,则初始化目标节点的孩子节点集合为set
						children = new HashSet<>();
					} else
						children = new ArrayList<>();// 否则初始化为list
				}
				// 将当前节点添加到目标节点的孩子节点
				children.add(cc);
				// 重设目标节点的孩子节点集合,这里必须重设,因为如果目标节点的孩子节点是null的话,这样是没有地址的,就会造成数据丢失,所以必须重设,如果目标节点所在类的孩子节点初始化为一个空集合,而不是null,则可以不需要这一步,因为java一切皆指针
				childrenField.set(c, children);
				// 递归添加孩子节点
				addChild(cc, collection, idField, parentField, childrenField);
			}
		}
		// 可以看到此递归没有明显出口,其出口就是是否当前节点的依赖值和目标节点的被依赖值一样,一样就递归,不一样进不了if,自然出递归
	}

	/**
	 * 为目标节点添加孩子
	 * 
	 * @author Sun Rising
	 * @date 2019.06.26 10:06:32
	 * @param c          目标节点
	 * @param collection 目标集合
	 * @param clazz      集合元素所在类型
	 *
	 */
	public static <T> void addChild(@NotNull T c, @NotNull Collection<T> collection, @NotNull Class<T> clazz) {
		addChild(c, collection, null, null, null, null, clazz);
	}

	/**
	 * 为目标节点添加孩子
	 * 
	 * @author Sun Rising
	 * @date 2019.06.26 10:07:15
	 * @param c          目标节点
	 * @param collection 目标集合
	 * @param id         被依赖字段名
	 * @param parent     依赖字段名
	 * @param children   孩子节点字段名
	 * @param clazz      集合元素所在类别
	 *
	 */
	public static <T> void addChild(@NotNull T c, @NotNull Collection<T> collection, String root, String id, String parent, String children, @NotNull Class<T> clazz) {
		try {
			if (collection == null || collection.isEmpty())
				return;// 如果目标集合为空,直接返回一个空树
			if (StringUtils.isEmpty(id))
				id = KEY;// 如果被依赖字段名称为空则默认为id
			if (StringUtils.isEmpty(parent))
				parent = PARENTKEY;// 如果依赖字段为空则默认为parent
			if (StringUtils.isEmpty(children))
				children = CHILDREN;// 如果子节点集合属性名称为空则默认为children
			if (StringUtils.isEmpty(root))
				root = ROOT;// 如果子节点集合属性名称为空则默认为root
			Field idField = null;
			try {
				idField = clazz.getDeclaredField(id);// 获取依赖字段
			} catch (NoSuchFieldException e1) {
				idField = clazz.getSuperclass().getDeclaredField(id);
			}
			Field parentField = null;
			try {
				parentField = clazz.getDeclaredField(parent);// 获取被依赖字段
			} catch (NoSuchFieldException e1) {
				parentField = clazz.getSuperclass().getDeclaredField(parent);
			}
			Field childrenField = null;// 获取孩子字段
			try {
				childrenField = clazz.getDeclaredField(children);
			} catch (NoSuchFieldException e1) {
				childrenField = clazz.getSuperclass().getDeclaredField(children);
			}
			// 设置为可访问
			idField.setAccessible(true);
			parentField.setAccessible(true);
			childrenField.setAccessible(true);
			addChild(c, collection, idField, parentField, childrenField);
			// 关闭可访问
			idField.setAccessible(false);
			parentField.setAccessible(false);
			childrenField.setAccessible(false);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
