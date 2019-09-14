package br.com.testepratico.enext.parsegame;

import br.com.testepratico.enext.parsegame.domain.Game;
import br.com.testepratico.enext.parsegame.domain.Player;
import br.com.testepratico.enext.parsegame.util.ParseUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

@SpringBootApplication
public class ParseGameApplication implements CommandLineRunner {

	private StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		SpringApplication.run(ParseGameApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Path caminhoLog = Paths.get("games.log");

		Stream<String> lines = Files.lines(caminhoLog, StandardCharsets.ISO_8859_1);
		List<Game> games = ParseUtil.readText(lines);
		ObjectMapper jackeson = new ObjectMapper();
		System.out.println(jackeson.writerWithDefaultPrettyPrinter().writeValueAsString(games));
	}
}
