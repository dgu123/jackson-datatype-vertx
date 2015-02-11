package de.crunc.jackson.datatype.vertx;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.crunc.jackson.datatype.vertx.generator.JsonElementGenerator;
import de.crunc.jackson.datatype.vertx.parser.JsonElementParser;
import org.vertx.java.core.json.JsonArray;
import org.vertx.java.core.json.JsonElement;
import org.vertx.java.core.json.JsonObject;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Provides operations that help using {@link ObjectMapper} to convert between object instances and {@link JsonObject}
 * / {@link JsonArray}.
 *
 * @author Hauke Jaeger, hauke.jaeger@googlemail.com
 * @since 2.1
 */
public class ObjectMarshaller {

    /**
     * Used for converting instances to/from JSON.
     */
    private final ObjectMapper om;

    /**
     * The object mapper which is used by this marshaller.
     *  
     * @return An object mapper.
     * @since 1.0
     */
    public ObjectMapper objectMapper() {
        return om;
    }

    /**
     * Creates a new marshaller that uses the given object mapper for (un-)marshalling.
     *
     * @param objectMapper The object mapper that will be used.
     * @throws IllegalArgumentException If the given objectMapper is {@code null}.
     * @since 2.1
     */
    public ObjectMarshaller(ObjectMapper objectMapper) {
        if (objectMapper == null) {
            throw new IllegalArgumentException("objectMapper must not be null");
        }

        om = objectMapper;
    }

    /**
     * Unmarshalls the given element to an instance of the given type.
     *
     * @param jsonElement The element that will be unmarshalled.
     * @param type        The type of the instance that will be created.
     * @param <T>         The type of the instance that will be created.
     * @return A new instance of the given type.
     * @throws IOException If unmarshalling fails.
     * @since 2.1
     */
    public <T> T unmarshall(JsonElement jsonElement, Class<T> type) throws IOException {
        return om.readValue(new JsonElementParser(jsonElement), type);
    }

    /**
     * Unmarshalls the given element to an instance of the given type.
     *
     * @param jsonElement The element that will be unmarshalled.
     * @param type        The type of the instance that will be created.
     * @param <T>         The type of the instance that will be created.
     * @return A new instance of the given type.
     * @throws IOException If unmarshalling fails.
     * @since 2.1
     */
    public <T> T unmarshall(JsonElement jsonElement, TypeReference<T> type) throws IOException {
        return om.readValue(new JsonElementParser(jsonElement), type);
    }

    /**
     * Unmarshalls the given element to an instance of the given type.
     *
     * @param jsonElement The element that will be unmarshalled.
     * @param type        The type of the instance that will be created.
     * @param <T>         The type of the instance that will be created.
     * @return A new instance of the given type.
     * @throws IOException If unmarshalling fails.
     * @since 2.1
     */
    public <T> T unmarshall(JsonElement jsonElement, JavaType type) throws IOException {
        return om.readValue(new JsonElementParser(jsonElement), type);
    }

    /**
     * Unmarshalls the given element to an instance of the given type.
     *
     * @param builder The element that will be unmarshalled.
     * @param type    The type of the instance that will be created.
     * @param <T>     The type of the instance that will be created.
     * @return A new instance of the given type.
     * @throws IOException If unmarshalling fails.
     * @since 2.1
     */
    public <T> T unmarshall(JsonObjectBuilder builder, Class<T> type) throws IOException {
        return unmarshall(builder.build(), type);
    }

    /**
     * Unmarshalls the given element to an instance of the given type.
     *
     * @param builder The element that will be unmarshalled.
     * @param type    The type of the instance that will be created.
     * @param <T>     The type of the instance that will be created.
     * @return A new instance of the given type.
     * @throws IOException If unmarshalling fails.
     * @since 2.1
     */
    public <T> T unmarshall(JsonObjectBuilder builder, TypeReference<T> type) throws IOException {
        return unmarshall(builder.build(), type);
    }

    /**
     * Unmarshalls the given element to an instance of the given type.
     *
     * @param builder The element that will be unmarshalled.
     * @param type    The type of the instance that will be created.
     * @param <T>     The type of the instance that will be created.
     * @return A new instance of the given type.
     * @throws IOException If unmarshalling fails.
     * @since 2.1
     */
    public <T> T unmarshall(JsonObjectBuilder builder, JavaType type) throws IOException {
        return unmarshall(builder.build(), type);
    }

    /**
     * Unmarshalls the given element to an instance of the given type.
     *
     * @param builder The element that will be unmarshalled.
     * @param type    The type of the instance that will be created.
     * @param <T>     The type of the instance that will be created.
     * @return A new instance of the given type.
     * @throws IOException If unmarshalling fails.
     * @since 2.1
     */
    public <T> T unmarshall(JsonArrayBuilder builder, Class<T> type) throws IOException {
        return unmarshall(builder.build(), type);
    }

    /**
     * Unmarshalls the given element to an instance of the given type.
     *
     * @param builder The element that will be unmarshalled.
     * @param type    The type of the instance that will be created.
     * @param <T>     The type of the instance that will be created.
     * @return A new instance of the given type.
     * @throws IOException If unmarshalling fails.
     * @since 2.1
     */
    public <T> T unmarshall(JsonArrayBuilder builder, TypeReference<T> type) throws IOException {
        return unmarshall(builder.build(), type);
    }

    /**
     * Unmarshalls the given element to an instance of the given type.
     *
     * @param builder The element that will be unmarshalled.
     * @param type    The type of the instance that will be created.
     * @param <T>     The type of the instance that will be created.
     * @return A new instance of the given type.
     * @throws IOException If unmarshalling fails.
     * @since 2.1
     */
    public <T> T unmarshall(JsonArrayBuilder builder, JavaType type) throws IOException {
        return unmarshall(builder.build(), type);
    }

    /**
     * Marshalls the given instance to a {@link JsonElement}.
     *
     * @param instance The instance that will be marshalled.
     * @param <T>      The type of {@link JsonElement} that is produced.
     * @return A new {@link JsonElement} that equals the given instance.
     * @throws IOException If marshalling fails.
     * @since 2.1
     */
    @SuppressWarnings("unchecked")
    public <T extends JsonElement> T marshall(Object instance) throws IOException {
        JsonElementGenerator jgen = new JsonElementGenerator(0, om);
        om.writeValue(jgen, instance);
        return (T) jgen.get();
    }
}
