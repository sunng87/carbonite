package carbonite;

import clojure.lang.RT;
import clojure.lang.Var;
import com.esotericsoftware.kryo.Kryo;

public class JavaBridge {
    static Var require = RT.var("clojure.core", "require");
    static Var symbol = RT.var("clojure.core", "symbol");

    static Var defaultReg;
    static Var regSerializers;
    static Var cljPrimitives;
    static Var javaPrimitives;
    static Var cljCollections;

    static {
        try {
            require.invoke(symbol.invoke("carbonite.api"));
            require.invoke(symbol.invoke("carbonite.serializer"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        defaultReg = RT.var("carbonite.api", "default-registry");
        regSerializers = RT.var("carbonite.api", "register-serializers");
        cljPrimitives = RT.var("carbonite.serializer", "clojure-primitives");
        javaPrimitives = RT.var("carbonite.serializer", "java-primitives");
        cljCollections = RT.var("carbonite.serializer", "clojure-collections");
    }

    public static void registerPrimitives(Kryo registry) throws Exception {
        regSerializers.invoke(registry, cljPrimitives.deref());
    }

    public static void registerCollections(Kryo registry) throws Exception {
        regSerializers.invoke(registry, cljCollections.invoke(registry));
    }

    public static void registerJavaPrimitives(Kryo registry) throws Exception {
        regSerializers.invoke(registry, javaPrimitives.deref());
    }

    public static Kryo defaultRegistry() throws Exception {
        return (Kryo)defaultReg.invoke();
    }

    public static void enhanceRegistry(Kryo registry) throws Exception {
        registerPrimitives(registry);
        registerJavaPrimitives(registry);
        registerCollections(registry);
    }
}
