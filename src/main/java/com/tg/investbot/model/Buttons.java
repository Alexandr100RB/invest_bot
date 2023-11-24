package com.tg.investbot.model;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

/**
 * TODO javadoc
 *
 * @author Alexey Chuyko (aachuyko@yoomoney.ru)
 * @since 24.11.2023
 */
public class Buttons {
    private static final InlineKeyboardButton START_BUTTON = new InlineKeyboardButton("Start");
    private static final InlineKeyboardButton HELP_BUTTON = new InlineKeyboardButton("Help");

    public static InlineKeyboardMarkup inlineMarkup() {
        START_BUTTON.setCallbackData("/start");
        HELP_BUTTON.setCallbackData("/help");

//        List rowInline = List.of(START_BUTTON, HELP_BUTTON);
//        List rowsInLine = List.of(rowInline);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(
                List.of(
                        List.of(START_BUTTON, HELP_BUTTON),
                        List.of(START_BUTTON, HELP_BUTTON))
        );

        return markupInline;
    }
}