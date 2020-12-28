import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setClassForTemplateLoading(App.class, "templates");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);
        configuration.setFallbackOnNullLoopVariable(false);

        Product product = new Product();
        product.setName("java");
        product.setPrice(new BigDecimal(12000));
        product.setDesc("目前最流行的面向对象语言");
        Product product1 = new Product();
        product1.setName("python");
        product1.setPrice(new BigDecimal(14000));
        product1.setDesc("目前热度最高的语言");
        List<Product> list = new ArrayList<>();
        list.add(product);
        list.add(product1);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("user" , "luther");
        hashMap.put("url" , "products/greenMouse.html");
        hashMap.put("name" , "green mouse");
        hashMap.put("products", list);

        Template template = configuration.getTemplate("test.ftl");

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
        template.process(hashMap, outputStreamWriter);
    }

    public static class Product {
        private String name;
        private BigDecimal price;
        private String desc;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}
