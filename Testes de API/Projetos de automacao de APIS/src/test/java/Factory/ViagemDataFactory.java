package Factory;

import Pojo.Viagem;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ViagemDataFactory {


    public static Viagem criarViagem(String viagemvalida) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/Resources/requestBody/postV1Viagens.json");

        if (file.exists()) {
            JsonNode jsonNode = objectMapper.readTree(file);
            JsonNode viagemNode = jsonNode.get(viagemvalida);

            if (viagemNode != null) {
                return objectMapper.treeToValue(viagemNode, Viagem.class);
            } else {
                throw new IllegalArgumentException("Variação de viagem não encontrada: " + viagemvalida);
            }
        } else {
            throw new FileNotFoundException("Arquivo JSON não encontrado");
        }
    }


    public static Viagem Criarviagemvalida() throws IOException {
        Viagem viagemvalida = criarViagem("viagemvalida");


        return viagemvalida;
    }

    public static Viagem CriarviagemInvalida() throws IOException {
        Viagem viagemInvalida = criarViagem("viageminvalida");


        return viagemInvalida;
    }

    public static Viagem CriarviagemSemosCamposObrigatorios() throws IOException {
        Viagem viagemsemcamposobrigatorios = criarViagem("viagemsemcamposobrigatorios");


        return viagemsemcamposobrigatorios;
    }
}


