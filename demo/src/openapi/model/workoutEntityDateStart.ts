/**
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
import { WorkoutEntityDateStartDateFormatSymbols } from './workoutEntityDateStartDateFormatSymbols';
import { WorkoutEntityDateStartTimeZone } from './workoutEntityDateStartTimeZone';
import { WorkoutEntityDateStartNumberFormat } from './workoutEntityDateStartNumberFormat';


export interface WorkoutEntityDateStart { 
    calendar?: string;
    numberFormat?: WorkoutEntityDateStartNumberFormat;
    get2DigitYearStart?: string;
    dateFormatSymbols?: WorkoutEntityDateStartDateFormatSymbols;
    timeZone?: WorkoutEntityDateStartTimeZone;
    lenient?: boolean;
}
