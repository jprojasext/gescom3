import { Validators, ValidatorFn, AbstractControl, ValidationErrors } from '@angular/forms';

export class Validator {


  public static validateDecimal(): ValidatorFn {

    //tipo de validadores
    const baseValidator = Validators.pattern(/^[0-9]+(\.[0-9]{1,2})?$/);
    const minValidator = Validators.min(0.01);
  
    return (control: AbstractControl): ValidationErrors | null => {
      const validationResult = baseValidator(control);
      const validationMinResult = minValidator(control);
  
      const errors: ValidationErrors = {};
  
      // Verificar si la validación de patrón falló
      if (validationResult !== null && validationResult !== undefined) {
        errors['message'] = 'text.validation.number';
      } else {
        // Verificar si la validación de número mayor que cero falló
        if (validationMinResult !== null && validationMinResult !== undefined) {
          errors['message'] = 'text.validation.zeroErrorMessage';
        }
      }
  
      return Object.keys(errors).length !== 0 ? errors : null;
    };
  }

  public static validateNumber(maxValue?: number): ValidatorFn {

    const integerValidator = Validators.pattern(/^[0-9]+$/); // Acepta solo números enteros
    const decimalValidator = Validators.pattern(/^\d+(\.\d+)?$/); // Acepta números decimales
    const minValidator = Validators.min(1);
    const maxValidator = maxValue !== undefined ? Validators.max(maxValue) : null;
  
    return (control: AbstractControl): ValidationErrors | null => {
      const integerValidationResult = integerValidator(control);
      const decimalValidationResult = decimalValidator(control);
      const validationMinResult = minValidator(control);
      const validationMaxResult = maxValidator !== null ? maxValidator(control) : null;
  
      const errors: ValidationErrors = {};
  
      // Verificar si es un número entero
      if (integerValidationResult !== null && integerValidationResult !== undefined) {
        // No es un número entero, intenta verificar si es un número decimal
        if (decimalValidationResult !== null && decimalValidationResult !== undefined) {
          // Es un número decimal, muestra el mensaje correspondiente
          errors['message'] = 'text.validation.number';
        } else {
          // No es un número, muestra el mensaje correspondiente
          errors['message'] = 'text.validation.onlyIntegerValues';
        }
      } else {
        // Verificar si es mayor que cero
        if (validationMinResult !== null && validationMinResult !== undefined) {
          // No es mayor que cero, muestra el mensaje correspondiente
          errors['message'] = 'text.validation.zeroErrorMessage';
        } else {
          // Verificar si no supera el valor máximo (si se proporciona)
          if (validationMaxResult !== null && validationMaxResult !== undefined) {
            // Supera el valor máximo, muestra el mensaje correspondiente
            errors['message'] = 'text.validation.maxValue';
          }
        }
      }
  
      return Object.keys(errors).length !== 0 ? errors : null;
    };
  }

}