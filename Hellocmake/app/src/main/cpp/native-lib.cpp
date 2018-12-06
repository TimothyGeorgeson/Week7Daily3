#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_consultants_hello_1cmake_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_consultants_hello_1cmake_MainActivity_sumFromJNI(
        JNIEnv* env,
        jobject /* this */,
        jint a,
        jint b) {
    int temp = a + b;
    std::string str = std::to_string(temp);
    std::string result = "Sum from C++: " + str;
    return env->NewStringUTF(result.c_str());
}