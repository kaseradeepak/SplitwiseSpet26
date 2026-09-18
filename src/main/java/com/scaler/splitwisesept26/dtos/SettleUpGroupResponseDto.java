package com.scaler.splitwisesept26.dtos;

import com.scaler.splitwisesept26.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    private List<Expense> expenses;
    private ResponseStatus responseStatus;
}
