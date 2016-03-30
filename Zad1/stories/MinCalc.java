import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.steps.CandidateSteps;


public class MinCalc {

	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays.asList("MinCalc.story");
	
	public static void main(String[] args) {
		embedder.candidateSteps().add(new MinSteps());
		embedder.runStoriesAsPaths(storyPaths);
	}

}
