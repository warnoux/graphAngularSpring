import {Component, OnInit} from '@angular/core';
import {Element} from './metier/element';
import {GraphService} from './graph.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  // weights = [1, 100, 1 , 50, 75, 25, 80, 80];
  weights;
  elements: Array<Element>;
  varCalculDifference = 100 / 30;

  increase = 'i';
  decrease = 'd';

  constructor(private graphService: GraphService) {  }

  ngOnInit(): void {
    this.elements = new Array<Element>();

    this.graphService.getElements().subscribe(value => {
      this.weights = value;
      this.initiateArray();
    });
  }

  generateAllPoints(): void  {
    this.elements.forEach((element, index) => {
      const nextElement = this.elements[index + 1];
      let evolution = '';
      let calculEvolution = 0;
      if (nextElement && element.positionCss <= nextElement.positionCss) {
        evolution = this.increase;
      } else {
        evolution = this.decrease;
      }

      if (nextElement && nextElement.positionCss === element.positionCss) {
        calculEvolution = 0;
      } else {
        if ( nextElement ){
          if ( nextElement.positionCss > element.positionCss ) {
          calculEvolution = nextElement.positionCss - element.positionCss ;
          } else {
            calculEvolution = element.positionCss - nextElement.positionCss ;
          }
        } else {
          calculEvolution = 0;
        }
      }

      element.styleCss = 'p' + evolution + element.positionCss + ' ' + (evolution === this.decrease ? evolution + ' ' : '') + evolution + calculEvolution;
    });
  }

  private initiateArray(): void {
    this.weights.forEach((poidsArray, index) => {
      const element: Element = new Element();
      element.positionCss = Math.floor(poidsArray.poids / this.varCalculDifference);
      element.poids = poidsArray.poids;
      this.elements.push(element);
    });
    this.generateAllPoints();
  }
}
