package valeriialebedeva.niffler.jupiter;

import okhttp3.OkHttpClient;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.support.AnnotationSupport;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import valeriialebedeva.niffler.api.CategoryApi;
import valeriialebedeva.niffler.model.CategoryJson;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static valeriialebedeva.niffler.jupiter.SpendExtension.NAMESPACE;

public class CategoryExtension implements BeforeEachCallback, ParameterResolver {
    public static final ExtensionContext.Namespace NAMESPACE
            = ExtensionContext.Namespace.create(SpendExtension.class);

    private static final OkHttpClient httpClient = new OkHttpClient.Builder().build();
    private static final Retrofit retrofit = new Retrofit.Builder()
            .client(httpClient)
            .baseUrl("http://127.0.0.1:8093")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    private final CategoryApi categoryApi = retrofit.create(CategoryApi.class);

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        Optional<GenerateCategory> category = AnnotationSupport.findAnnotation(
                extensionContext.getRequiredTestMethod(),
                GenerateCategory.class
        );

        if (category.isPresent()) {
            GenerateCategory categoryData = category.get();
            CategoryJson categoryJson = new CategoryJson(
                    null,
                    categoryData.category(),
                    categoryData.username()
            );

            if (isUnique(categoryData.username(), categoryData.category())) {
                CategoryJson created = categoryApi.addCategory(categoryJson).execute().body();
                extensionContext.getStore(NAMESPACE)
                        .put("category", created);
            }
        }
    }

    private boolean isUnique(String username, String category) throws IOException {
        List<CategoryJson> categories =  categoryApi.getAllCategoriesByUser(username).execute().body();
        return Objects.requireNonNull(categories).stream()
                .noneMatch(c -> category.equals(c.category()));
    }


    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter()
                .getType()
                .isAssignableFrom(CategoryJson.class);
    }

    @Override
    public CategoryJson resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return extensionContext.getStore(NAMESPACE)
                .get("category", CategoryJson.class);
    }
}
