package br.com.testepratico.enext.parsegame;

import br.com.testepratico.enext.parsegame.repository.DeathRepository;
import br.com.testepratico.enext.parsegame.repository.GameRepository;
import br.com.testepratico.enext.parsegame.util.ParseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@SpringBootApplication
public class ParseGameApplication implements CommandLineRunner {

	@Autowired
	GameRepository repositoryGame;
	@Autowired
	DeathRepository repositoryDeath;
	public static void main(String[] args) {
		SpringApplication.run(ParseGameApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Path caminhoLog = Paths.get("games.log");

		Stream<String> lines = Files.lines(caminhoLog, StandardCharsets.ISO_8859_1);
		ParseUtil.readText(lines);
		ObjectMapper jackeson = new ObjectMapper();
		System.out.println("******************************RESULTADO DOS JOGOS********************************");
		System.out.println(jackeson.writerWithDefaultPrettyPrinter().writeValueAsString(repositoryGame.findAll()));

		System.out.println("******************************RANKING DOS JOGOS********************************");
		System.out.println(jackeson.writerWithDefaultPrettyPrinter().writeValueAsString(repositoryGame.ranking()));

		System.out.println("******************************MORTES AGRUPADAS POR MOTIVO********************************");
		System.out.println(jackeson.writerWithDefaultPrettyPrinter().writeValueAsString(repositoryDeath.findAll()));
	}
}
