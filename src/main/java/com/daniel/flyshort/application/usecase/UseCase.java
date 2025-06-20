package com.daniel.flyshort.application.usecase;

public interface UseCase<I, O> {
    
    O execute(I input);

}
