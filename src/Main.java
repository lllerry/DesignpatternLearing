import abstract_factory.IButton;
import abstract_factory.ITextView;
import abstract_factory.ImageStyleFactory;
import builder.ConcreteBuilder;
import builder.Director;
import builder.Product;
import builder.noodle_demo.Noodle;
import factory_method.AbsFactory;
import factory_method.AndroidFactory;
import factory_method.IOSFactory;
import org.junit.Test;
import prototype.ConcretePrototype;
import prototype.IPrototype;
import simple_factory.IProduct;
import simple_factory.Product_Optimize;
import simple_factory.SimpleFactory;
import singleton.ActivityManager;
import singleton.TaskManager;

public class Main {

    /**
     * 工厂方法模式
     */
    @Test
    public void factory_method() {
        AbsFactory factory;

        factory = new AndroidFactory();
        factory.draw();

        factory = new IOSFactory();
        factory.draw();
    }

    /**
     * 简单工厂模式
     */
    @Test
    public void simple_factory() {
        IProduct product_1 = SimpleFactory.create(1);

        IProduct product_2 = SimpleFactory.create(2);
    }

    /**
     * 抽象工厂模式
     */
    @Test
    public void abstract_factory() {
        ImageStyleFactory imageStyleFactory = new ImageStyleFactory();
        IButton button = imageStyleFactory.createButton();
        ITextView textView = imageStyleFactory.createTextView();
    }

    /**
     * 优化过的简单工厂模式
     */
    @Test
    public void simple_factory_optimize() {
        Product_Optimize.create(1).display();
    }

    /**
     * 初级建造者模式
     */
    @Test
    public void builder_primary() {
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        Director director = new Director(concreteBuilder);
        Product product = director.construct();
    }

    /**
     * 进阶建造者模式
     */
    @Test
    public void builder_advanced() {
        Noodle noodle = new Noodle.Builder()
                .addChili("chili")
                .addPeanut("peanut")
                .addSalt("salt")
                .build();
    }

    /**
     * 单例模式
     */
    @Test
    public void singleton() {
        ActivityManager activityManager = ActivityManager.getInstance();
        TaskManager taskManager = TaskManager.getInstance();
    }

    /**
     * 通用原型模式
     */
    @Test
    public void prototype_common() {
        IPrototype concretePrototype = new ConcretePrototype();
        IPrototype prototype = concretePrototype.clone();
    }

    public void prototype_java() {

    }
}
