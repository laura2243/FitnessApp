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
import { TypeEntity } from './typeEntity';
import { WorkoutEntity } from './workoutEntity';


export interface ExerciseEntity { 
    id?: number;
    name?: string;
    description?: string;
    duration?: number;
    height?: number;
    kg?: number;
    age?: number;
    workout?: Array<WorkoutEntity>;
    type?: TypeEntity;
}
