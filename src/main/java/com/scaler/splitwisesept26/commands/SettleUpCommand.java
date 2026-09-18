package com.scaler.splitwisesept26.commands;

import com.scaler.splitwisesept26.controllers.SettleUpController;
import com.scaler.splitwisesept26.dtos.SettleUpUserRequestDto;
import com.scaler.splitwisesept26.dtos.SettleUpUserResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpCommand implements Command {
    private SettleUpController settleUpController;

    public SettleUpCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String command) {
        // input command - settleup user 1234

        List<String> words = List.of(command.split(" "));

        return words.size() == 3 && words.get(0).equalsIgnoreCase("settleup");
    }

    @Override
    public void execute(String command) {
        List<String> words = List.of(command.split(" "));

        Long id = Long.parseLong(words.get(2));

        String settleUpType = words.get(1);

        if (settleUpType.equalsIgnoreCase("user")) {
            //settleUpUser

            SettleUpUserRequestDto requestDto = new SettleUpUserRequestDto();
            requestDto.setUserId(id);

            SettleUpUserResponseDto responseDto = settleUpController.settleUpUser(requestDto);
        } else {
            //settleUpGroup


        }

    }
}
