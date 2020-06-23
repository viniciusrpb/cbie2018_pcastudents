function graficosSBIE(eige,propor,nameEigenvalues,number)

    eigenvalues = eige(1:number);
    
    proportion = propor(1:number);

    cumulative = cumsum(proportion);
    
    x = 1:numel(proportion);
    
    figure,bar(x,proportion);
    
    axis([0 number+1 0 0.95]);
    
    hold on;
    
    plot(cumulative,'Color','red','LineWidth',2);
    
    for i1=1:numel(proportion)
    text(x(i1),proportion(i1),num2str(eigenvalues(i1),'%0.2f'),...
               'HorizontalAlignment','center',...
               'VerticalAlignment','bottom')
    end
    
    xlabel('Principal components');
    ylabel('Proportion of variance');
    
    print(nameEigenvalues,'-dpng');

end