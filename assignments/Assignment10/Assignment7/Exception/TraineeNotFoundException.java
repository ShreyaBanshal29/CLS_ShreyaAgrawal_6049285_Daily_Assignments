package com.example.Assignment7.Exception;

public class TraineeNotFoundException extends RuntimeException{
	    public TraineeNotFoundException(){
        super("TraineeNotFound");
	    }
}
