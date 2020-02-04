import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //createObservableWithJust();
        //createObservableFromArray();
        createObservableFromCreate();
    }

    private static void createObservableFromJust() {
        Observable observable = Observable.just(1, 2, 3, 4, 5);
        observable.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer item) throws Exception {
                System.out.println(item);
            }
        });
    }

    private static void createObservableFromArray() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Observable observable = Observable.fromIterable(list);
        observable.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer item) throws Exception {
                System.out.println(item);
            }
        });
    }

    private static void createObservableFromCreate() {
        Observable observable = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(4);
            emitter.onNext(5);
            emitter.onComplete();

        });
        observable.subscribe(item -> System.out.println(item), error -> System.out.println(error),
                () -> System.out.println("Completed"));
    }
}
