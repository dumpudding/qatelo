package com.qatelo.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Faculty {
	KINESIOLOGY_SPORT_RECREATION("Faculty of Kinesiology, Sport, and Recreation"),
	MEDICINE_DENTISTRY("Faculty of Medicine and Dentistry"),
	NURSING("Faculty of Nursing"),
	PHARMACY_PHARMACEUTICAL_SCIENCES("Faculty of Pharmacy and Pharmaceutical Sciences"),
	PUBLIC_HEALTH("School of Public Health"),
	REHABILITATION_MEDICINE("Faculty of Rehabilitation Medicine"),
	AGRICULTURAL_LIFE_ENV_SCI("Faculty of Agricultural, Life and Environmental Sciences [ALES]"),
	ENGINEERING("Faculty of Engineering"),
	SCIENCE("Faculty of Science"),
	ARTS("Faculty of Arts"),
	BUSINESS("Faculty of Business"),
	EDUCATION("Faculty of Education"),
	LAW("Faculty of Law"),
	AUGUSTANA("Augustana Faculty"),
	NATIVE_STUDIES("Faculty of Native Studies"),
	SAINTJEAN_ENGLISH("Faculté Saint-Jean (English)"),
	SAINTJEAN_FRENCH("Faculté Saint-Jean (En Français)"),
	GRADUATE_POSTDOCTORAL("Faculty of Graduate & Postdoctoral Studies"),
	NONE("None");

	private final String displayName;
}