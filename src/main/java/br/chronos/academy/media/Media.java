package br.chronos.academy.media;

public class Media {
    public String calculaMedia(double n1, double n2) {
        double media = (n1 + n2) / 2;
        if (media < 5) {
            return "Reprovado";
        }
        return "Aprovado";
    }
}