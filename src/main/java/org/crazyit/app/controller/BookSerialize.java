package org.crazyit.app.controller;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.crazyit.app.domain.Book;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class BookSerialize {
    public static class Serializer extends JsonSerializer<Book> {
        @Override
        public void serialize(Book book, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            System.out.println("序列化");
            // 输出对象开始的Token(也就是左括号)
            jsonGenerator.writeStartObject();
            // 依次输出Book的4个属性
            jsonGenerator.writeNumberField("id", book.getId());
            // 对book的title属性，此处序列化为name
            jsonGenerator.writeObjectField("name", book.getTitle());
            jsonGenerator.writeObjectField("author", book.getAuthor());
            jsonGenerator.writeNumberField("price", book.getPrice());
            jsonGenerator.writeEndObject();
        }
    }

    public static class Deserializer extends JsonDeserializer<Book> {

        @Override
        public Book deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
            System.out.println("反序列化");
            var book = new Book();
            // 开始解析JSON字符串
            JsonToken jsonToken = jsonParser.getCurrentToken();
            String fieldName = null;
            // 如果还未解析到对象结束
            while (!jsonToken.equals(JsonToken.END_OBJECT)) {
                if (!jsonToken.equals(JsonToken.FIELD_NAME)) {
                    jsonToken = jsonParser.nextToken();
                    continue;
                }
                // 解析到field名
                fieldName = jsonParser.getCurrentName();
                // 解析下一个token(field名之后就是field值)
                jsonToken = jsonParser.nextToken();
                try {
                    // 如果fieldName是name，则为field值的前后添加书名号
                    if (fieldName.equals("title")) {
                        String name = jsonParser.getText();
                        if (!name.startsWith("<")) {
                            name = "<" + name;
                        }
                        if (!name.endsWith(">")) {
                            name = name + ">";
                        }
                        book.setTitle(name);
                    }
                    // 如果fieldName是price，则将价格打折
                    else if (fieldName.equals("price")) {
                        book.setPrice(jsonParser.getDoubleValue() * 0.8);
                    }
                    // 对于其他fieldName，调用fieldName默认对应的setter方法
                    else {
                        BeanUtils.getPropertyDescriptor(Book.class, fieldName)
                                .getWriteMethod().invoke(book, jsonParser.getText());
                    }
                    // 解析下一个Token
                    jsonToken = jsonParser.nextToken();
                } catch (Exception e) {
                    System.out.println("反序列化过程中出现异常: " + e);
                }
            }
            return book;
        }
    }
}
