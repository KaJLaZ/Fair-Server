package game.core.chooseFate;

import lombok.NonNull;

public class History {
    private Litigation litigation;
    private String posSequence;
    private String negSequence;

    public History(@NonNull Litigation litigation, @NonNull String posSequence, @NonNull String negSequence) {
        this.litigation = litigation;
        this.posSequence = posSequence;
        this.negSequence = negSequence;
    }

    public Litigation getLitigation() {
        return litigation;
    }

    public String getPosSequence() {
        return posSequence;
    }

    public String getNegSequence() {
        return negSequence;
    }
}

