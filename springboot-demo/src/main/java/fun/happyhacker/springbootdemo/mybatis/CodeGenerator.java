package fun.happyhacker.springbootdemo.mybatis;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

public class CodeGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir") + "/springboot-demo";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("happyhacker");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.99.101:3308/order?charset=utf8mb4");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("order");
        dsc.setPassword("order!");
        mpg.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("fun.happyhacker.springbootdemo.mybatis");
        mpg.setPackageInfo(pc);

//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//
//            }
//        };

//        String templatePath = "/templates/mapper.xml.vm";
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategyConfig.setSuperEntityClass("父类Entity，没有可以不用设置");
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
//        strategyConfig.setSuperControllerClass("父类Controller，没有就不用设置");
        strategyConfig.setSuperEntityColumns("id");
//        strategyConfig.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategyConfig);
        mpg.execute();
    }

    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入 " + tip + "：");

        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }

        throw new MybatisPlusException("请输入正确的 " + tip + "！");
    }
}
