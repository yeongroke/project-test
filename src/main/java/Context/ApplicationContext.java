package Context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.apache.ibatis.io.Resources;

import Annotation.Component;

public class ApplicationContext {
    HashMap<String, Object> objpool = new HashMap<>();
    
    public ApplicationContext(String packagename) throws Exception{
        String path =packagename.replace(".", "/");
        
        File file = Resources.getResourceAsFile(path);
        
        findclass(file,path);
    }
    
    public Object getBean(String name) {
        return objpool.get(name);
    }
    
    private void findclass(File path,String packagePath) throws Exception{
        File[] files = path.listFiles();
        
        for(File file : files)
        {
            if(file.isDirectory()) {
                findclass(file , packagePath + "/" + file.getName());
            }else {
                String className = (packagePath + "/" + file.getName())
                        .replace("/", ".").replace(".class", "");
                
                Class<?> clazz = Class.forName(className);
                
                if(clazz.isInterface()) continue;
                try {
                   Constructor<?> constructor = clazz.getConstructor();
                   Object instance = constructor.newInstance();
                   Field field = clazz.getField("name");
                   Component anno = clazz.getAnnotation(Component.class);
                   Object name = field.get(instance);
                   objpool.put(anno.value(), instance);
                }catch(Exception e) {
                    System.out.printf("%s 클래스는 기본생성자가 없습니다 \n",clazz.getName());
                }
            }
        }
    }
}
