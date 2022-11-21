package com.example.ssm;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("NewClassNamingConvention")
class AutoCodeGenerator {

    @Test
    void generate() {
        String projectPath = System.getProperty("user.dir");
        String outputDir = projectPath + "/src/main/java";
        String url = "jdbc:mysql://127.0.0.1:3306/ssm?useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "root";
        FastAutoGenerator.create(new DataSourceConfig.Builder(url, username, password)
                        // .schema("public")
                        // 数据库查询
                        .dbQuery(new MySqlQuery())
                        // 数据库类型转换器
                        .typeConvert(new MySqlTypeConvert())
                        // 数据库关键字处理器
                        .keyWordsHandler(new MySqlKeyWordsHandler()))
                // 全局配置
                .globalConfig(builder ->
                        // 设置作者
                        builder.author("auto-generator")
                                // 禁止打开输出目录
                                .disableOpenDir()
                                // java.time 包新时间类型
                                .dateType(DateType.TIME_PACK)
                                // 指定注释日期格式化
                                .commentDate("yyyy/M/d")
                                // 指定输出目录
                                .outputDir(outputDir))
                // 包配置
                .packageConfig(builder -> {
                    Map<OutputFile, String> pathInfo = new HashMap<>(8);
                    // 不生成 Controller、Service、ServiceImpl，所以不配置它们的路径信息
                    pathInfo.put(OutputFile.entity, outputDir + "/com/example/ssm/entity");
                    pathInfo.put(OutputFile.mapper, outputDir + "/com/example/ssm/mapper");
                    pathInfo.put(OutputFile.xml, projectPath + "/src/main/resources/mapper");
                    // 设置父包名、文件生成路径信息
                    builder.parent("com.example.ssm").pathInfo(pathInfo);
                })
                // 策略配置
                .strategyConfig(builder ->
                        // 设置需要生成的表名，ATTENTION: 这里注意不要覆盖掉原来的
                        builder.addInclude("t_user", "t_group", "t_user_group_relation")
                                // 设置不需要生成的表名
                                // .addExclude(...)
                                // 禁用 sql 过滤
                                .disableSqlFilter()
                                // 设置过滤表前缀
                                .addTablePrefix("t_")
                                // ===> Controller Builder <===
                                // .controllerBuilder()
                                // 覆盖已生成文件
                                // .enableFileOverride()
                                // .superClass("com.example.ssm.entity.BaseController")
                                // .enableRestStyle()
                                // .enableHyphenStyle()
                                // ===> Service Builder <===
                                // .serviceBuilder()
                                // .enableFileOverride()
                                // ===> Entity Builder <===
                                .entityBuilder()
                                .enableFileOverride()
                                .naming(NamingStrategy.underline_to_camel)
                                .columnNaming(NamingStrategy.underline_to_camel)
                                // .superClass("com.example.ssm.entity.BaseEntity")
                                // .addSuperEntityColumns("id")
                                .enableColumnConstant()
                                .enableChainModel()
                                .enableLombok()
                                // .enableColumnConstant()
                                .enableTableFieldAnnotation()
                                // ===> Mapper Builder <===
                                .mapperBuilder()
                                .enableFileOverride()
                                .enableBaseResultMap()
                                .enableBaseColumnList())
                // 设置 Freemarker 引擎
                .templateEngine(new FreemarkerTemplateEngine())
                // 模板配置
                .templateConfig(builder ->
                        // builder.disable(TemplateType.CONTROLLER, TemplateType.SERVICE, TemplateType.SERVICE_IMPL, TemplateType.MAPPER, TemplateType.XML)
                        // 不生成 Controller、Service、ServiceImpl
                        builder.disable(TemplateType.CONTROLLER, TemplateType.SERVICE))
                .execute();
    }
}
