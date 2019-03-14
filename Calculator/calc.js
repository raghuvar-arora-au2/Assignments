const calculator = document.querySelector('.calculator')
const keys = calculator.querySelector('.calculator__keys')
const display = calculator.querySelector('.calculator__display')
const calculate = (n1, operator, n2) => {
  let result = ''
  if (operator == 'add'){
    result = parseFloat(n1) + parseFloat(n2)
  } else if (operator == 'subtract'){
    result = parseFloat(n1) - parseFloat(n2)
  } else if (operator == 'multiply'){
    result = parseFloat(n1) * parseFloat(n2)
  } else if (operator == 'divide'){
    result = parseFloat(n1) / parseFloat(n2)
  }
  return result
}
var firstValue = 0
var secondValue = 0
var previousKeyType = 'number'
var operator = ''

keys.addEventListener('click', e=>{
  
  if (e.target.classList.contains('number')){
    if(display.textContent == '0' || previousKeyType == 'operator' ){
      clear.textContent = 'C'
      display.textContent = e.target.textContent
    } else{
      display.textContent = display.textContent + e.target.textContent
    }
  }
  
  if (e.target.dataset.action == 'decimal'){
    if(display.textContent.indexOf('.') == -1) {
      display.textContent = display.textContent + e.target.textContent
      clear.textContent = 'C'
    }
  }
  
  if (e.target.dataset.action == 'plus-minus'){
    if(display.textContent != '0'){
      display.textContent = display.textContent * (-1)
    }
  }
  
  if (e.target.dataset.action == 'percent'){
    if(display.textContent != '0'){
      display.textContent = display.textContent / 100
    }
  }
  
  if (e.target == clear) {
    firstValue = 0
    secondValue = 0
    previousKeyType = 'number'
    display.textContent = '0'
    clear.textContent = 'AC'
    Array.from(e.target.parentNode.children)
      .forEach(k => k.classList.remove('is-selected'))
  }
  
  if(e.target.dataset.action == 'add' ||
      e.target.dataset.action == 'subtract' ||
      e.target.dataset.action == 'multiply' ||
      e.target.dataset.action == 'divide'){
    operator = e.target.dataset.action
    Array.from(e.target.parentNode.children)
      .forEach(k => k.classList.remove('is-selected'))
    e.target.classList.add('is-selected')
    if (firstValue != 0 && previousKeyType == 'number'){
      secondValue = display.textContent
      display.textContent = calculate(firstValue,operator,secondValue)
    }
    firstValue = display.textContent
    previousKeyType = 'operator'
  }else{
    previousKeyType = 'number'
  }
  
  if(e.target.dataset.action == 'calculate'){
    secondValue = 0
    if(previousKeyType == 'number'){
      secondValue = display.textContent
    }
    if (operator!=''){
      display.textContent = calculate(firstValue,operator,secondValue)
    }
    previousKeyType = 'operator'
    firstValue = display.textContent
    operator = ''
    Array.from(e.target.parentNode.children)
      .forEach(k => k.classList.remove('is-selected'))
  }
 
})



