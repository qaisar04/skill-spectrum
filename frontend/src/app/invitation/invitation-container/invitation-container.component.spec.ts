import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvitationContainerComponent } from './invitation-container.component';

describe('InvitationContainerComponent', () => {
  let component: InvitationContainerComponent;
  let fixture: ComponentFixture<InvitationContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InvitationContainerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InvitationContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
