package com.bridgelabz.fundoo.label.repository;

import com.bridgelabz.fundoo.label.model.Label;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface LabelRepository extends R2dbcRepository<Label, Integer> {
}
