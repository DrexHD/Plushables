package com.khazoda.plushables.tooltip;

import com.khazoda.plushables.block.tooltip.TooltipData;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class TooltipDataBuilder {
  private String number = com.khazoda.plushables.block.tooltip.TooltipData.DEFAULT.number();
  private String artist = com.khazoda.plushables.block.tooltip.TooltipData.DEFAULT.artist();
  private long creationTimestamp = com.khazoda.plushables.block.tooltip.TooltipData.DEFAULT.creationTimestamp();
  private String originalDate = null;  // Store original date string as fallback
  private String trivia = com.khazoda.plushables.block.tooltip.TooltipData.DEFAULT.trivia();

  public static TooltipDataBuilder create() {
    return new TooltipDataBuilder();
  }

  public TooltipDataBuilder number(int number) {
    this.number = "#" + number;
    return this;
  }

  public TooltipDataBuilder artist(String artist) {
    this.artist = artist;
    return this;
  }

  public TooltipDataBuilder creationDate(String creationDate) {
    // Store original input as ultimate fallback
    this.originalDate = creationDate;
    // Date formats listed from most desired to least, as multiple fallbacks
    DateTimeFormatter[] formatters = {
        // Format with ordinal indicators
        DateTimeFormatter.ofPattern("d['st']['nd']['rd']['th'] MMMM yyyy"),
        // Standard formats
        DateTimeFormatter.ofPattern("d MMMM yyyy"),
        DateTimeFormatter.ofPattern("dd/MM/yyyy"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd")
    };

    LocalDate parsedDate = null;
    for (DateTimeFormatter formatter : formatters) {
      try {
        parsedDate = LocalDate.parse(creationDate, formatter);
        break;
      } catch (Exception ignored) {
        // Try next fallback format
      }
    }

    if (parsedDate != null) {
      this.creationTimestamp = parsedDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    } else {
      // If parsing fails, set timestamp to 0 to indicate we should use fallback
      this.creationTimestamp = 0;
    }
    return this;
  }

  public TooltipDataBuilder trivia(@Nullable String trivia) {
    this.trivia = trivia;
    return this;
  }

  public com.khazoda.plushables.block.tooltip.TooltipData build() {
    return new TooltipData(number, artist, creationTimestamp, originalDate, trivia);
  }
}
