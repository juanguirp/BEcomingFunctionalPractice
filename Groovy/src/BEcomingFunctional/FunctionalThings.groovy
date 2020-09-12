package BEcomingFunctional

class FunctionalThings {

    def <T> List<T> FilterWithRecursion(List<T> list, Closure cls) {
        if(list.isEmpty()){
            return []
        } else {
            return (cls(list.head()) ? [list.head()] : []) + Filter(list.tail(), cls)
        }
    }
}
