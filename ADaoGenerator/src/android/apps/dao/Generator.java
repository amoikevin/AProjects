package android.apps.dao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Generator {

	public static void main(String[] args) {
		Schema schema = new Schema(1, "android.articles.models");
		schema.setDefaultJavaPackageDao("android.articles.daos");
		
//		schema2.enableKeepSectionsByDefault();
//		schema2.enableActiveEntitiesByDefault();
		
		addArticle(schema);
		try {
			new DaoGenerator().generateAll(schema, "src");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addArticle(Schema schema){
		Entity article = schema.addEntity("Article");
		article.setTableName("article");
		article.addIdProperty();
		article.addStringProperty("title").notNull();
		article.addStringProperty("author");
		article.addStringProperty("editor");
		article.addStringProperty("catalog").notNull();
		article.addStringProperty("tags");
		article.addStringProperty("content");
		article.addLongProperty("time");
	}

}
