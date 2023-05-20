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
import { RoleEntity } from './roleEntity';
import { WorkoutEntity } from './workoutEntity';


export interface UserEntity { 
    id?: number;
    name?: string;
    email?: string;
    height?: number;
    kg?: number;
    age?: number;
    username?: string;
    password?: string;
    role?: RoleEntity;
    workouts?: Array<WorkoutEntity>;
}
