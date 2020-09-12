package BEcomingFunctional

class FunctionalThings {

    def <T> List<T> FilterWithRecursion(List<T> list, Closure cls) {
        if(list.isEmpty()){
            return []
        } else {
            return (cls(list.head()) ? [list.head()] : []) + FilterWithRecursion(list.tail(), cls)
        }
    }

    def <T> List<T> FilterWithTailRecursion(List<T> list, List<T> output, Closure cls){
        if(list.isEmpty()){
            return output
        } else {
            return FilterWithTailRecursion(list.tail(), cls(list.head()) ? output + list.head() : output, cls)
        }
    }
}
