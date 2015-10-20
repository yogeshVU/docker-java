package com.github.dockerjava.api.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.NullNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// This is not going to be serialized
@JsonDeserialize(using = Mounts.Deserializer.class)
@JsonSerialize(using = Mounts.Serializer.class)
public class Mounts {
    private final Mount[] mounts;

    public Mounts(Mount... mounts) {
        this.mounts = mounts;
    }

    public Mount[] getMounts() {
        return mounts;
    }

    public static final class Serializer extends JsonSerializer<Mounts> {

        @Override
        public void serialize(Mounts value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
                JsonProcessingException {
            jgen.writeStartObject();
            for (final Mount mount : value.mounts) {
                jgen.writeStringField("Name", mount.getName());
                jgen.writeStringField("Source", mount.getSource());
                jgen.writeStringField("Destination", mount.getDestination());
                jgen.writeStringField("Driver", mount.getDriver());
                jgen.writeStringField("Mode", mount.getMode());
                jgen.writeBooleanField("RW", mount.getRW());
            }
            jgen.writeEndObject();
        }
    }

    public static final class Deserializer extends JsonDeserializer<Mounts> {
        @Override
        public Mounts deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                throws IOException, JsonProcessingException {

            List<Mount> mounts = new ArrayList<Mount>();
            ObjectCodec oc = jsonParser.getCodec();

            ArrayNode nodes = oc.readTree(jsonParser);
            for(JsonNode node : nodes) {
                // TODO Add validation
                Mount bind = new Mount(node.get("Name").asText(),
                        node.get("Source").asText(), node.get("Destination").asText(),
                        node.get("Driver").asText(), node.get("Mode").asText(),
                        node.get("RW").asBoolean());
                mounts.add(bind);
            }
            return new Mounts(mounts.toArray(new Mount[mounts.size()]));
        }
    }

}
