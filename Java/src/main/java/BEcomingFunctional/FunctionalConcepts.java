package BEcomingFunctional;

import java.util.ArrayList;
import java.util.List;

public class FunctionalConcepts {
    public FunctionalConcepts(){}

    public static <A1, B> List<B> map(
            List<A1> inList,
            Function1<A1, B> function
    ){
        List<B> outList = new ArrayList<>();
        for (A1 obj : inList) {
            outList.add(function.call(obj));
        }
        return outList;
    }

    public static <A> void foreach(
            List<A> inList,
            Foreach1<A> function
    ){
        for (A obj : inList) {
            function.call(obj);
        }
    }

    public static <A> List<A> filter(
            List<A> inList,
            Function1<A, Boolean> test
    ){
        List<A> outList = new ArrayList<>();
        for (A obj : inList) {
            if(test.call(obj)){
                outList.add(obj);
            }
        }
        return outList;
    }
}
