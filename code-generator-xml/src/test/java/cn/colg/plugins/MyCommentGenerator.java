package cn.colg.plugins;

import java.util.Properties;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * 扩展生成实体类的规则
 *
 * @author colg
 */
public class MyCommentGenerator implements CommentGenerator {

	private boolean suppressAllComments;

	public MyCommentGenerator() {
		suppressAllComments = false;
	}

	@Override
	public void addConfigurationProperties(Properties properties) {
		suppressAllComments = StringUtility
				.isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
	}

	/**
	 * field 注释
	 */
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}

		String remarks = introspectedColumn.getRemarks();// 字段注释
		field.addJavaDocLine("/**");
		field.addJavaDocLine(" * " + remarks);
		field.addJavaDocLine(" */");

		// ============================= @id, @Column BEGIN
		/*
		String columnName = introspectedColumn.getActualColumnName();
		int length = introspectedColumn.getLength();
		boolean nullable = introspectedColumn.isNullable();
		String fieldType = field.getType().toString();
		StringBuffer sb = new StringBuffer();

		List<IntrospectedColumn> pklist = introspectedTable.getPrimaryKeyColumns();
		boolean columnIsPkCol = false;
		if (pklist != null && pklist.size() > 0) {
			for (IntrospectedColumn col : pklist) {
				if (col.getActualColumnName().equalsIgnoreCase(columnName)) {
					columnIsPkCol = true;
					break;
				}
			}
		}

		if (columnIsPkCol) {
			field.addAnnotation("@Id");
		}

		sb.append("@Column(name = \"" + columnName + "\"");
		if (fieldType.endsWith("String")) {
			sb.append(", length = " + length + "");
		}
		if (!nullable) {
			sb.append(", nullable = " + nullable + "");
		}
		sb.append(")");
		field.addAnnotation(sb.toString());
		*/
		// ============================= @id, @Column END

	}

	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
	}

	/**
	 * class 注释
	 */
	@Override
	public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}

		topLevelClass.addJavaDocLine("/**");
		topLevelClass.addJavaDocLine(" * ");
		topLevelClass.addJavaDocLine(" *");
		topLevelClass.addJavaDocLine(" * @author colg");
		topLevelClass.addJavaDocLine(" */");
		System.out.println(introspectedTable.getRemarks());

		// ======================= @Table BEGN
		/*
		String tableName = introspectedTable.getFullyQualifiedTable().toString();// 表名
		topLevelClass.addAnnotation("@Table(name = \"" + tableName + "\")");
		*/
		// ======================= @Table END
	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
	}

	@Override
	public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
	}

	/**
	 * get 注释
	 */
	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}

		String lowerCase = introspectedColumn.getActualColumnName();// 字段名
		String remarks = introspectedColumn.getRemarks(); // 字段注释
		method.addJavaDocLine("/**");
		method.addJavaDocLine(" * 获取" + remarks);
		method.addJavaDocLine(" *");
		method.addJavaDocLine(" * @return " + lowerCase + " - " + remarks);
		method.addJavaDocLine(" */");
	}

	/**
	 * set 注释
	 */
	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}

		String remarks = introspectedColumn.getRemarks(); // 字段注释
		String name = method.getParameters().get(0).getName();
		method.addJavaDocLine("/**");
		method.addJavaDocLine("/* 设置" + name);
		method.addJavaDocLine(" *");
		method.addJavaDocLine(" * @param " + name + " " + remarks);
		method.addJavaDocLine(" */");
	}

	@Override
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
	}

	@Override
	public void addJavaFileComment(CompilationUnit compilationUnit) {
	}

	@Override
	public void addComment(XmlElement xmlElement) {
	}

	@Override
	public void addRootComment(XmlElement rootElement) {
	}

}