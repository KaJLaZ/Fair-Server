package game.core.chooseFate;

import lombok.NonNull;

public class History {
    private Litigation litigation;
    public Litigation getLitigation() {
        return litigation;
    }

    private String posSequence;
    public String getPosSequence() {
        return posSequence;
    }

    private String negSequence;
    public String getNegSequence() {
        return negSequence;
    }

    public History(@NonNull Litigation litigation, @NonNull String posSequence, @NonNull String negSequence) {
        this.litigation = litigation;
        this.posSequence = posSequence;
        this.negSequence = negSequence;
    }
}

