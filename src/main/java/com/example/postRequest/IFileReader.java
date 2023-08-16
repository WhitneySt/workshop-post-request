package com.example.postRequest;

public interface IFileReader<T> {
    FileLines<T> readFile(ProcessorFile processorFile);
}
