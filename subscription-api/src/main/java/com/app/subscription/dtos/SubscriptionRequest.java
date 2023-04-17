package com.app.subscription.dtos;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

import com.app.subscription.entities.Subscription;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonNaming(PropertyNamingStrategies.KebabCaseStrategy.class)
public class SubscriptionRequest {

	@NotEmpty(message = "name is a mandatory field")
	private String name;
	@Email(message = "email format is not valid")
	private String email;
	@NotNull(message = "user-type is a mandatory field")
	private UserType userType;
	@NotEmpty(message = "company is a mandatory field")
	private String company;
	@NotNull(message = "application-type is a mandatory field")
	private ApplicationType applicationType;

	public Subscription toSubscription() {
		Subscription subscription = new Subscription();
		subscription.setId(UUID.randomUUID().toString());
		subscription.setName(sanitizeString(name));
		subscription.setEmail(sanitizeString(email));
		subscription.setUserType(userType);
		subscription.setCompany(sanitizeString(company));
		subscription.setApplicationType(applicationType);
		subscription.setDateTime(LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC));
		return subscription;
	}

	public static String sanitizeString(String input) {
		return Jsoup.clean(StringEscapeUtils.escapeHtml4(StringEscapeUtils.escapeEcmaScript(escapeSql(input))),
				Safelist.basic());
	}

	public static String escapeSql(String str) {
		if (str == null) {
			return null;
		}
		return StringUtils.replace(str, "'", "''");
	}

}
