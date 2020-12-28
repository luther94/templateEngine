import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");

//        // 这2行代码等于下面一行代码，因resource.loader默认为file，所以可以简写成一行
//        properties.setProperty("resource.loader", "classpath");
//        properties.setProperty("classpath.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader" +
                ".ClasspathResourceLoader");
        Velocity.init(properties);

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

        VelocityContext context = new VelocityContext();
        context.put("user" , "luther");
        context.put("url" , "products/greenMouse.html");
        context.put("name" , "green mouse");
        context.put("products", list);

        Template template = Velocity.getTemplate("templates/test.vm");

        StringWriter stringWriter = new StringWriter();
        template.merge(context, stringWriter);

        System.out.println(stringWriter.toString());
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
