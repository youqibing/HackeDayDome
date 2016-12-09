package com.example;

import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;

public class MyGreenDaoClass {

    public static void main(String args[]) throws Exception {
        // 创建了一个用于添加实体（Entity）的模式（Schema）对象。
        // 两个参数分别代表：数据库版本号与自动生成代码的包路径。
        Schema schema = new Schema(2, "greendao");
        schema.enableKeepSectionsByDefault();

        // 一旦你拥有了一个 Schema 对象后，你便可以使用它添加实体（Entities）了。
        goods(schema);

        // 最后我们将使用 DAOGenerator 类的 generateAll() 方法自动生成代码，此处你需要根据自己的情况更改输出目录（既之前创建的 java-gen)。
        new DaoGenerator().generateAll(schema, "././app/src/main/java-gen");     //有时候这里是"../app/src/main/java-gen",这个跟windows平台有关，多试几次
    }

    /**
     * @param schema
     */
    private static void goods(Schema schema) {
        // 一个实体（类）就关联到数据库中的一张表，此处表名为「Student」（既类名）
        Entity entity = schema.addEntity("Goods");
        // 你也可以重新给表命名
        // note.setTableName("Student2");

        // greenDAO 会自动根据实体类的属性值来创建表字段，并赋予默认值
        // 接下来你便可以设置表中的字段：
        // 与在 Java 中使用驼峰命名法不同，默认数据库中的命名是使用大写和下划线来分割单词的。
        entity.addLongProperty("goods_id").primaryKey();
        entity.addIntProperty("goods_rank");
        entity.addIntProperty("goods_home_type");
        entity.addStringProperty("goods_name");
        entity.addStringProperty("goods_detail");
        entity.addStringProperty("goods_user_avatar");
        entity.addStringProperty("goods_image_url");
        entity.addIntProperty("goods_favorites_num");
        entity.addIntProperty("goods_comment_num");
        entity.addStringProperty("goods_user_cert_info");
        entity.addStringProperty("goods_user_nickname");
        entity.addIntProperty("goods_price");
        entity.addIntProperty("goods_user_id");
        entity.addStringProperty("goods_release_time");
        entity.addIntProperty("goods_class_id");
        entity.addIntProperty("goods_trade_place_id");
    }

}
