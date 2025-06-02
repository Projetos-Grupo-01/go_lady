package com.generation.golady.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class ViagemService {

	public BigDecimal calculaPreco(Float distancia) {
		BigDecimal valorPreco = BigDecimal.valueOf(distancia * 1.5);
		return valorPreco;

	}

	public LocalDateTime calculaHorarioChegada(Float distancia) {
		int tempoTrajeto = (int)Math.round(distancia * 3);
		LocalDateTime horarioAtual = LocalDateTime.now();
		LocalDateTime horarioChegada = horarioAtual.plusMinutes(tempoTrajeto);
		return horarioChegada;

	}
}
