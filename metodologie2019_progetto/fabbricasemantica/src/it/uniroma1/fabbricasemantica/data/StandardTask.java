package it.uniroma1.fabbricasemantica.data;

/**
 * Enumerazione contenente tutti i possibli task
 */

public enum StandardTask implements Task {
	TRANSLATION_ANNOTATION,
	WORD_ANNOTATION,
	DEFINITION_ANNOTATION,
	SENSE_ANNOTATION,
	TRANSLATION_VALIDATION,
	SENSE_VALIDATION,
	MY_ANNOTATION,
}
