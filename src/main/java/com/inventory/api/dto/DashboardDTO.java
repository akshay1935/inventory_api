package com.inventory.api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DashboardDTO {
	private long productCount;
	private long availableCount;
	private long emptyCount;
}
