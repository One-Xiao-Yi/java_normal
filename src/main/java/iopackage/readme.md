##IO
###InputStream / OutputStream
####IO流以byte为最小单位，因此也称为字节流。
####InputStream代表输入字节流，OutputStream代表输出字节流。
###Reader / Writer
####如果读写的是字符，字符不全是单字节，所以以char为单位读写更容易，这种方式称为字符流。
####字符流最小单位为char。将字节按照编码方式进行解码，既可得到字符，所以Reader/Writer本质上是自动解码的InputStream/OutputStream
###同步和异步
####同步指读写IO时，必须等待IO读写完成，才能继续执行之后的代码，代码编写简单，CPU执行效率低。
####异步指无需等待IO读写完成，发送IO请求后立即执行后续代码，CPU执行效率高，但代码编写复杂。
####本次只学习同步IO

##字节流与字符流差别
#### InputStream   |     Reader   |   OutputStream    |    Writer
#### 以byte为单位 |   以char为单位 |  以byte为单位  |  以char为单位
#### 读取字节(-1，0～255)   |   读取字节（-1，0～65535）| 写入字节（0～255） | 写入字节（0～65535）