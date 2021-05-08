package mocks.TC3.configuration;

import lombok.Builder;

import java.util.List;

@Builder
public class AbTesting {

    public List<Experiment> experiments;

    public static AbTesting getDefault() {
        return AbTesting.builder().experiments(Experiment.getDefaultExperiments()).build();
    }
}
