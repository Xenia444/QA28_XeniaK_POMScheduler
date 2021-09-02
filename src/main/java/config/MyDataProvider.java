package config;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[] > validLoginData(){
        List<Object[]> list= new ArrayList<>();

        list.add(new Object[]{"Mike@gmail.co","Mike@gmailco"});
        list.add(new Object[]{"John@gmail.co","John@gmailco"});
        list.add(new Object[]{"Sara@gmail.co","Sara@gmailco"});

        return list.iterator();
    }
}
