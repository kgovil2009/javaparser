package me.tomassetti.symbolsolver.javaparsermodel.declarations;

import com.github.javaparser.ast.body.EnumDeclaration;
import me.tomassetti.symbolsolver.model.declarations.ValueDeclaration;
import me.tomassetti.symbolsolver.model.resolution.TypeSolver;
import me.tomassetti.symbolsolver.model.typesystem.ReferenceTypeUsageImpl;
import me.tomassetti.symbolsolver.model.typesystem.TypeUsage;

public class JavaParserEnumConstantDeclaration implements ValueDeclaration {

    private TypeSolver typeSolver;
    private com.github.javaparser.ast.body.EnumConstantDeclaration wrappedNode;

    public JavaParserEnumConstantDeclaration(com.github.javaparser.ast.body.EnumConstantDeclaration wrappedNode, TypeSolver typeSolver) {
        this.wrappedNode = wrappedNode;
        this.typeSolver = typeSolver;
    }

    @Override
    public TypeUsage getType() {
        return new ReferenceTypeUsageImpl(new JavaParserEnumDeclaration((EnumDeclaration) wrappedNode.getParentNode(), typeSolver), typeSolver);
    }

    @Override
    public String getName() {
        return wrappedNode.getName();
    }

	/**
	 * Returns the JavaParser node associated with this JavaParserEnumConstantDeclaration.
	 *
	 * @return A visitable JavaParser node wrapped by this object.
	 */
	public com.github.javaparser.ast.body.EnumConstantDeclaration getWrappedNode()
	{
		return wrappedNode;
	}

}
