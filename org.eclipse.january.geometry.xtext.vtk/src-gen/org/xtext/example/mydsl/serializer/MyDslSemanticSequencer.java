/*
 * generated by Xtext 2.10.0
 */
package org.xtext.example.mydsl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.january.geometry.Face;
import org.eclipse.january.geometry.Geometry;
import org.eclipse.january.geometry.GeometryPackage;
import org.eclipse.january.geometry.PolyShape;
import org.eclipse.january.geometry.TriangleStripPolyShape;
import org.eclipse.january.geometry.Vertex;
import org.eclipse.january.geometry.VertexSource;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;

@SuppressWarnings("all")
public class MyDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MyDslGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == GeometryPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case GeometryPackage.FACE:
				sequence_Face(context, (Face) semanticObject); 
				return; 
			case GeometryPackage.GEOMETRY:
				sequence_Geometry(context, (Geometry) semanticObject); 
				return; 
			case GeometryPackage.POLY_SHAPE:
				sequence_PolyShape(context, (PolyShape) semanticObject); 
				return; 
			case GeometryPackage.TRIANGLE_STRIP_POLY_SHAPE:
				sequence_TriangleStripPolyShape(context, (TriangleStripPolyShape) semanticObject); 
				return; 
			case GeometryPackage.VERTEX:
				sequence_Vertex(context, (Vertex) semanticObject); 
				return; 
			case GeometryPackage.VERTEX_SOURCE:
				sequence_VertexSource(context, (VertexSource) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Face returns Face
	 *
	 * Constraint:
	 *     vertexIndices+=EInt+
	 */
	protected void sequence_Face(ISerializationContext context, Face semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Geometry returns Geometry
	 *
	 * Constraint:
	 *     (name=EString (vertexSources+=VertexSource | nodes+=PolyShape | nodes+=TriangleStripPolyShape)*)
	 */
	protected void sequence_Geometry(ISerializationContext context, Geometry semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PolyShape returns PolyShape
	 *
	 * Constraint:
	 *     faces+=Face+
	 */
	protected void sequence_PolyShape(ISerializationContext context, PolyShape semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TriangleStripPolyShape returns TriangleStripPolyShape
	 *
	 * Constraint:
	 *     faces+=Face+
	 */
	protected void sequence_TriangleStripPolyShape(ISerializationContext context, TriangleStripPolyShape semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     VertexSource returns VertexSource
	 *
	 * Constraint:
	 *     vertices+=Vertex+
	 */
	protected void sequence_VertexSource(ISerializationContext context, VertexSource semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Vertex returns Vertex
	 *
	 * Constraint:
	 *     (x=EDouble y=EDouble z=EDouble)
	 */
	protected void sequence_Vertex(ISerializationContext context, Vertex semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GeometryPackage.Literals.VERTEX__X) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GeometryPackage.Literals.VERTEX__X));
			if (transientValues.isValueTransient(semanticObject, GeometryPackage.Literals.VERTEX__Y) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GeometryPackage.Literals.VERTEX__Y));
			if (transientValues.isValueTransient(semanticObject, GeometryPackage.Literals.VERTEX__Z) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GeometryPackage.Literals.VERTEX__Z));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVertexAccess().getXEDoubleParserRuleCall_1_0(), semanticObject.getX());
		feeder.accept(grammarAccess.getVertexAccess().getYEDoubleParserRuleCall_2_0(), semanticObject.getY());
		feeder.accept(grammarAccess.getVertexAccess().getZEDoubleParserRuleCall_3_0(), semanticObject.getZ());
		feeder.finish();
	}
	
	
}
